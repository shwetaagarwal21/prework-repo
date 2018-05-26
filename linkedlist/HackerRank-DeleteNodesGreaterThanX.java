/*
Delete Nodes Greater Than x
*/
static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {
        if(listHead == null) return null;
        while(listHead.data > x){
            listHead = listHead.next;
        }
        if(listHead == null) return listHead;
        SinglyLinkedListNode temp = listHead.next;
        SinglyLinkedListNode prev = listHead;
        while(temp != null){
            if(temp.data > x){
                prev.next = temp.next;
                temp = prev.next;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        return listHead;
    }
