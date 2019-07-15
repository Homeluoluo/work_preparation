package data.structure.tree.mytree;

import java.util.List;

/**
 * @Classname ICommonTree
 * @Description 写一个类实现该接口
 * @Date 2019/4/28 23:24
 * @Created by luojia
 */
public interface ICommonTree {
//   从树中删除节点
    public MyNode addNode(Integer nodeId,MyNode newNode);

//    从树中删除节点
    public MyNode deleteNode(Integer nodeId);

//    判断两个节点是否为父子关系
    public boolean isParentAndChild(Integer parentId,Integer childId);

//    获取从父节点到字节点的路径
    public List<MyNode> getPath(Integer parentId, Integer childId);

//获取最近公共祖先Recent public ancestor
    public MyNode getNearestCommonAncestor(Integer childAId, Integer childBId);
}
