public class TreeNodeStack {
    int top;
    TreeNode[] t;

    TreeNodeStack() {
        top = -1;
        t = new TreeNode[100];
    }

    TreeNodeStack(int n) {
        top = -1;
        t = new TreeNode[n];
    }

    void push(TreeNode temp) {
        ++top;
        t[top] = temp;
    }

    TreeNode pop() {
        TreeNode temp;
        temp = t[top];
        --top;
        return temp;
    }

    boolean isEmpty () {
        boolean answer = false;
        if(top == -1) {
            answer = true;
        }
        return answer;
    }

    void showStack() {
        for(int i = 0; i <= top; ++i) {
            System.out.print(t[i].data);
        }
        System.out.println();
    }
}