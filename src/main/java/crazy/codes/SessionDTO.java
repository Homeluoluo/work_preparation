package crazy.codes;

import java.io.Serializable;

/**
 * @Classname SessionDTO
 * @Description TODO
 * @Date 2019/4/18 14:26
 * @Created by luojia
 */
public class SessionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int data; // Stores session data

    // Session activation time (creation, deserialization)
    private long activationTime;

    public SessionDTO(int data) {
        this.data = data;
        this.activationTime = System.currentTimeMillis();
    }

    public int getData() {
        return data;
    }

    public long getActivationTime() {
        return activationTime;
    }
}