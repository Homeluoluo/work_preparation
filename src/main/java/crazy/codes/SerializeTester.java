package crazy.codes;

import java.io.*;

/**
 * @Classname SerializeTester
 * @Description TODO
 * @Date 2019/4/18 14:27
 * @Created by luojia
 */
public class SerializeTester implements Serializable {
    public static void main(String[] strings) throws Exception {
        File file = new File("out.ser");

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        SessionDTO dto = new SessionDTO(1);
        oos.writeObject(dto);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
         dto = (SessionDTO) ois.readObject();

        System.out.println("data : " + dto.getData()
                + " activation time : " + dto.getActivationTime());
        ois.close();
    }
}
