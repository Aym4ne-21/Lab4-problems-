package problem2;

public class IntegerList
{
    int[] list; //values in the list
    int count = 0 ;
    int size ;
    //-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
        this.size = size;
    }
    //-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------
    public void randomize()
    {
        for (int i=0; i<list.length; i++) {
            list[i] = (int) (Math.random() * 100) + 1;
            count++;
        }

    }
    //-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<count; i++)
            System.out.println(i + ":\t" + list[i]);
    }


    public void IncreaseSize(){
        int newSize = (size == 0) ? 1 : size * 2;
        int[] newList = new int[newSize];

        for (int i =0; i < count; i++) {
            newList[i] = list[i];
        }
        list = newList;
        size = newSize;
    }

    public void addElement(int newVal){
        if(count == list.length ){
            IncreaseSize();
        }
        list[count] = newVal ;
        count++;
    }

    public void removeFirst(int newVal){
        for(int i = 0 ; i < count; i++ ){
            if(list[i] == newVal){
                for(int j =  i ; j < count - 1 ; j++){
                    list[j] = list[j + 1] ;
                }
                count--;
                return;
            }
        }
    }

    public void removeAll(int newVal){
        int i = 0;
        while (i < count) {
            if (list[i] == newVal) {
                for (int j = i; j < count - 1; j++) {
                    list[j] = list[j + 1];
                }
                count--;
            } else {
                i++;
            }
        }
    }
}