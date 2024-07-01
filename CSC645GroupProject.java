import java.io.*;
import java.util.*;
class HuffmanNode implements Comparable<HuffmanNode> {
char data;
int frequency;
HuffmanNode left, right;
public HuffmanNode(char data, int frequency) {
this.data = data;
this.frequency = frequency;
}
public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
this.frequency = frequency;
this.left = left;
this.right = right;
}
@Override
public int compareTo(HuffmanNode other) {
return this.frequency - other.frequency;
}
}
public class CSC645GroupProject {
public static void main(String[] args) {
String inputFilePath = "C:\\Users\\User\\Downloads\\100kb_special_character.txt";
String compressedFilePath =
"C:\\Users\\User\\Downloads\\TEST\\sirPunyaFileDari100kb.txt";
// Compress the file
compressFile(inputFilePath, compressedFilePath);
}
public static void compressFile(String inputFilePath, String outputFilePath) {
try (BufferedInputStream inputStream = new BufferedInputStream(new
FileInputStream(inputFilePath));
ObjectOutputStream outputStream = new ObjectOutputStream(new
FileOutputStream(outputFilePath))) {
// Step 1: Count character frequencies
Map<Character, Integer> frequencyMap = new HashMap<>();
int data;
while ((data = inputStream.read()) != -1) {
char ch = (char) data;
frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
}
// Step 2: Build Huffman Tree
PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
}
while (priorityQueue.size() > 1) {
HuffmanNode left = priorityQueue.poll();
HuffmanNode right = priorityQueue.poll();
priorityQueue.offer(new HuffmanNode(left.frequency + right.frequency, left, right));
}
HuffmanNode root = priorityQueue.poll();
// Step 3: Generate Huffman Codes
Map<Character, String> huffmanCodes = new HashMap<>();
generateCodes(root, "", huffmanCodes);
// Step 4: Write Huffman Codes to the output file
outputStream.writeObject(huffmanCodes);
// Use a separate variable to read the file again
try (BufferedInputStream newInputStream = new BufferedInputStream(new
FileInputStream(inputFilePath))) {
// Step 5: Write encoded data to the output file using a BitOutputStream
BitOutputStream bitOutputStream = new BitOutputStream(new
FileOutputStream(outputFilePath));
int readByte;
while ((readByte = newInputStream.read()) != -1) {
char ch = (char) readByte;
String code = huffmanCodes.get(ch);
for (char bit : code.toCharArray()) {
bitOutputStream.writeBit(bit == '1' ? 1 : 0);
}
}
bitOutputStream.close();
}
System.out.println("File compressed successfully.");
} catch (IOException e) {
e.printStackTrace();
}
}
private static void generateCodes(HuffmanNode node, String code, Map<Character, String>
huffmanCodes) {
if (node != null) {
if (node.left == null && node.right == null) {
huffmanCodes.put(node.data, code);
}
generateCodes(node.left, code + "0", huffmanCodes);
generateCodes(node.right, code + "1", huffmanCodes);
}
}
}
class BitOutputStream {
private FileOutputStream out;
private int currentByte;
private int numBitsFilled;
public BitOutputStream(FileOutputStream out) {
this.out = out;
this.currentByte = 0;
this.numBitsFilled = 0;
}
public void writeBit(int bit) throws IOException {
if (!(bit == 0 || bit == 1)) {
throw new IllegalArgumentException("Argument must be 0 or 1");
}
currentByte = currentByte << 1 | bit;
numBitsFilled++;
if (numBitsFilled == 8) {
out.write(currentByte);
currentByte = 0;
numBitsFilled = 0;
}
}
public void close() throws IOException {
while (numBitsFilled != 0) {
writeBit(0);
}
out.close();
}
}