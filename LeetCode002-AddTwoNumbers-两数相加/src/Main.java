import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        ListNode listNode = addTwoNumbers(l1,l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //数组列表存储每位计算结果
        ArrayList<Integer> resultArray = new ArrayList<>(0);
        int carry = 0;
        boolean flag1=true;
        boolean flag2=true;
        while(flag1 || flag2){

            int result = l1.val + l2.val + carry;
            carry = result>=10?1:0;
            result = result>=10?result-10:result;
            result = result%10;
            resultArray.add(result);
            //判断是否是最后的元素
            if(null==l1.next){
                l1.val=0;
                flag1=false;
            }else{
                l1=l1.next;
            }
            if(null==l2.next){
                l2.val=0;
                flag2=false;
            }else{
                l2=l2.next;
            }
        }
        //最后是否有进位
        if(carry==1){
            resultArray.add(carry);
        }

        //结果数组转为ListNode节点
        return createNode(resultArray);

    }


    //递归创建链表
    public static ListNode createNode(ArrayList<Integer> resultArray){
        if(0==resultArray.size()-1){
            return new ListNode(resultArray.get(0));
        }
        //数组剔除第一个元素
        int value = resultArray.get(0);
        resultArray.remove(0);
        return new ListNode(value,createNode(resultArray));
    }


}
