package data.structure.tree;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args){
        String str="you are my sunshine,my only sunshine,life is bueatiful.";
        System.out.println(str.length());
        byte[] bytes=str.getBytes();
        //进行哈夫曼编码
        byte[] result=huffmanZip(bytes);

        System.out.println(bytes.length);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }

    private static byte[] huffmanZip(byte[] bytes) {
        //统计每一个byte出现的次数，即计算Huffman节点的权,初始化每个结点
        List<HuffmanNode> nodes=getNodes(bytes);
        //创建哈夫曼树
        HuffmanNode huffmanTree = createHuffmanTree(nodes);
        //创建哈夫曼编码表
        Map<Byte,String> huffmanTable =getHuffmanCodes(huffmanTree);
        System.out.println(huffmanCodes);
        //编码
        byte[] b=zip(bytes,huffmanTable);
        return b;
    }

    /*
    进行哈夫曼编码
     */
    private static byte[] zip(byte[] bytes,Map<Byte, String> huffmanTable) {
        StringBuffer sb = new StringBuffer();
        //把需要压缩的byte数组处理为一个二进制的字符串
        for (byte aByte : bytes) {
            sb.append(huffmanTable.get(aByte));
        }
//        System.out.println(sb);
//        定义长度
        int len=0;
        //八位二进制数为一组
        if(sb.length()%8==0){
            len=sb.length()/8;
        }else{
            len=sb.length()/8+1;
        }
//        用于存储压缩后的byte
        byte[] by=new byte[len];
        //记录新byte的位置
        int index=0;
        for (int i = 0; i <sb.length() ; i+=8) {
            String strByte;
            if(i+8>sb.length()){
                strByte=sb.substring(i);
            }else{
                strByte=sb.substring(i,i+8);
            }
            byte num=(byte)Integer.parseInt(strByte,2);//radix表示strByte的进制数
            System.out.println(strByte+":"+num);
            by[index]=num;
            index++;
        }
        return by;
    }

    public static void printHuffmanTree(HuffmanNode node,StringBuffer codeStringBuffer){
        if(node.getValue()!=0){
            System.out.println(node.getValue()+": "+codeStringBuffer.toString());
        }
        if(node.getLeft()!=null){
            codeStringBuffer.append("0");
            printHuffmanTree(node.getLeft(),codeStringBuffer);
        }
        if(node.getRight()!=null){
            codeStringBuffer.append("1");
            printHuffmanTree(node.getRight(),codeStringBuffer);
        }
    }

    //用于临时存储路径
    static StringBuffer codeStringBuffer = new StringBuffer();
    //用于存储哈夫曼编码
    static Map<Byte, String> huffmanCodes=new HashMap<>();

    private static Map<Byte, String> getHuffmanCodes(HuffmanNode huffmanTree) {
        if(huffmanTree==null) {
            return null;
        }else{
            getHuffmanCodes(huffmanTree.getLeft(),"0",codeStringBuffer);
            getHuffmanCodes(huffmanTree.getRight(),"1",codeStringBuffer);
        }
        return huffmanCodes;
    }

    private static void getHuffmanCodes(HuffmanNode node, String code, StringBuffer codeStringBuffer) {
        StringBuffer codeStringBuffer2 = new StringBuffer(codeStringBuffer);
        codeStringBuffer2.append(code);
        if (node.getValue() == 0){
            getHuffmanCodes(node.getLeft(),"0",codeStringBuffer2);
            getHuffmanCodes(node.getRight(),"1",codeStringBuffer2);
        }else{
            huffmanCodes.put(node.getValue(),codeStringBuffer2.toString());
        }
    }

    private static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        Collections.sort(nodes);
//        int i=0;
        while (nodes.size()>1){
            HuffmanNode node=new HuffmanNode(nodes.get(1).getWeight()+nodes.get(0).getWeight());
            node.setLeft(nodes.get(0));
            node.setRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }

    private static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> nodes = new ArrayList<>();
        //计算权值
        Map<Byte,Integer> counts = new HashMap<>();
        for(byte b:bytes){
            Integer count=counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
        System.out.println(counts);
        //初始化节点
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new HuffmanNode(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

}
