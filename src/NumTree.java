public class NumTree {
    TreeNode root;
    int compares = 0;

    NumTree() {
        root = null;
    }

    TreeNode makeTreeNode(int num) {
        TreeNode temp = new TreeNode();
        temp.data = num;
        temp.left = null;
        temp.right = null;
        temp.freq = 1;
        return temp;
    }

    void buildOrderedTree(int[] numArray) {
        TreeNode temp;
        boolean searching;
        int currNum;

        for (int i = 0; i < numArray.length; i++) {
            currNum = numArray[i];
            if(i == 0) {
                root = makeTreeNode(currNum);
            }
            else {
                temp = root;
                searching = true;
                while (searching) {
                    if (currNum == temp.data) {
                        temp.freq++;
                        searching = false;
                        compares++;
                    }
                    else if (currNum < temp.data) {
                        if (temp.left == null) {
                            temp.left = makeTreeNode(currNum);
                            searching = false;
                            compares += 2;
                        }
                        else {
                            temp = temp.left;
                            compares += 2;
                        }
                    }
                    else {
                        if (temp.right == null) {
                            temp.right = makeTreeNode(currNum);
                            searching = false;
                            compares += 2;
                        } else {
                            temp = temp.right;
                            compares += 2;
                        }
                    }
                }
            }
        }
    }

    void recursiveInOrderPrint(TreeNode temp) {
        int dupCount;
        if (temp.left != null) {
            recursiveInOrderPrint(temp.left);
        }
        dupCount = temp.freq;
        while (dupCount != 0) {
            System.out.println(temp.data);
            dupCount -= 1;
        }
        if(temp.right != null) {
            recursiveInOrderPrint(temp.right);
        }
    }

    void iterativeInOrderPrintLowHigh(int numOfNodes) {
        TreeNode temp;
        TreeNodeStack tStack;

        System.out.println("All values in the binary tree printed in order iteratively: ");
        temp = root;
        tStack = new TreeNodeStack(numOfNodes);
        do {
            while(temp != null) {
                tStack.push(temp);
                temp = temp.left;
            }
            if(!tStack.isEmpty()) {
                temp = tStack.pop();
                for (int i = 0; i < temp.freq; i++) {
                    System.out.println(temp.data);
                }
                temp = temp.right;
            }
        }
        while(temp != null || !tStack.isEmpty());
    }
}