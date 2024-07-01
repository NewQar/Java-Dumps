import java.util.Scanner;

class MyBST {
  private Node root;

  private class Node {
    int value;
    Node left, right;

    Node(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void insert(int value) {
    root = insertRecursive(root, value);
  }

  private Node insertRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }

    if (value < current.value) {
      current.left = insertRecursive(current.left, value);
    } else if (value > current.value) {
      current.right = insertRecursive(current.right, value);
    }

    return current;
  }

  public void preorderTraversal() {
    preorderTraversalRecursive(root);
  }

  private void preorderTraversalRecursive(Node current) {
    if (current != null) {
      System.out.print(current.value + " ");
      preorderTraversalRecursive(current.left);
      preorderTraversalRecursive(current.right);
    }
  }

  public void inorderTraversal() {
    inorderTraversalRecursive(root);
  }

  private void inorderTraversalRecursive(Node current) {
    if (current != null) {
      inorderTraversalRecursive(current.left);
      System.out.print(current.value + " ");
      inorderTraversalRecursive(current.right);
    }
  }

  public void postorderTraversal() {
    postorderTraversalRecursive(root);
  }

  private void postorderTraversalRecursive(Node current) {
    if (current != null) {
      postorderTraversalRecursive(current.left);
      postorderTraversalRecursive(current.right);
      System.out.print(current.value + " ");
    }
  }

  public int calculateHeight() {
    return calculateHeightRecursive(root);
  }

  private int calculateHeightRecursive(Node current) {
    if (current == null) {
      return 0;
    }

    int leftHeight = calculateHeightRecursive(current.left);
    int rightHeight = calculateHeightRecursive(current.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public int findLevel(int value) {
    return findLevelRecursive(root, value, 1);
  }

  private int findLevelRecursive(Node current, int value, int level) {
    if (current == null) {
      return -1;
    }

    if (value == current.value) {
      return level;
    } else if (value < current.value) {
      return findLevelRecursive(current.left, value, level + 1);
    } else {
      return findLevelRecursive(current.right, value, level + 1);
    }
  }

  public int countNodes() {
    return countNodesRecursive(root);
  }

  private int countNodesRecursive(Node current) {
    if (current == null) {
      return 0;
    }

    int leftCount = countNodesRecursive(current.left);
    int rightCount = countNodesRecursive(current.right);

    return leftCount + rightCount + 1;
  }

  public int countLeaves() {
    return countLeavesRecursive(root);
  }

  private int countLeavesRecursive(Node current) {
    if (current == null) {
      return 0;
    }

    if (current.left == null && current.right == null) {
      return 1;
    }

    int leftCount = countLeavesRecursive(current.left);
    int rightCount = countLeavesRecursive(current.right);

    return leftCount + rightCount;
  }

  public int findMinimum() {
    if (root == null) {
      throw new IllegalStateException("BST is empty");
    }

    Node current = root;
    while (current.left != null) {
      current = current.left;
    }

    return current.value;
  }

  public int findMaximum() {
    if (root == null) {
      throw new IllegalStateException("BST is empty");
    }

    Node current = root;
    while (current.right != null) {
      current = current.right;
    }

    return current.value;
  }

  public int calculateTotal() {
    return calculateTotalRecursive(root);
  }

  private int calculateTotalRecursive(Node current) {
    if (current == null) {
      return 0;
    }

    int leftSum = calculateTotalRecursive(current.left);
    int rightSum = calculateTotalRecursive(current.right);

    return leftSum + rightSum + current.value;
  }

  public double calculateAverage() {
    int total = calculateTotal();
    int nodeCount = countNodes();

    if (nodeCount == 0) {
      throw new IllegalStateException("BST is empty");
    }

    return (double) total / nodeCount;
  }
}

public class BSTApplication {
  public static void main(String[] args) {
    MyBST bst = new MyBST();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter at least 20 numbers into the BST:");
    for (int i = 0; i < 20; i++) {
      int number = scanner.nextInt();
      bst.insert(number);
    }

    System.out.println("Preorder Traversal:");
    bst.preorderTraversal();
    System.out.println();

    System.out.println("Inorder Traversal:");
    bst.inorderTraversal();
    System.out.println();

    System.out.println("Postorder Traversal:");
    bst.postorderTraversal();
    System.out.println();

    System.out.println("Height of the BST: " + bst.calculateHeight());

    System.out.print("Enter a number to find its level in the BST: ");
    int value = scanner.nextInt();
    int level = bst.findLevel(value);
    if (level != -1) {
      System.out.println("Level of " + value + " in the BST: " + level);
    } else {
      System.out.println(value + " not found in the BST.");
    }

    System.out.println("Number of nodes in the BST: " + bst.countNodes());
    System.out.println("Number of leaves in the BST: " + bst.countLeaves());
    System.out.println("Minimum value in the BST: " + bst.findMinimum());
    System.out.println("Maximum value in the BST: " + bst.findMaximum());
    System.out.println("Total value of the BST: " + bst.calculateTotal());
    System.out.println("Average value of the BST: " + bst.calculateAverage());

    scanner.close();
  }
}
