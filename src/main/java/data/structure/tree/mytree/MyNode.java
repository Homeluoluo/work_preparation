package data.structure.tree.mytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MyNode
 * @Description TODO
 * @Date 2019/4/28 23:25
 * @Created by luojia
 */
public class MyNode {
    Integer NodeId;
    MyNode parent;
    List<MyNode> childs = new ArrayList<>();
}
