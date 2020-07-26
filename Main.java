public class Main {

    public static final int ARRAY_I = 4;
    public static final int ARRAY_J = 4;

    public static void main(String[] args) throws MyArrayException {

        String[][] ar = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};

        try {
            ArrayTypeChanger(ar);
        } catch (MyArrayException e) {
            System.out.printf(e.getMessage());
        }
    }

    public static void ArrayTypeChanger(String[][] arr) throws MyArrayException, MyArrayDataException, MyArraySizeException {

        int iSumm = 0;

        for (String[] i : arr
        ) {
            if (i.length > ARRAY_I || i.length < 0) throw
                    new MyArraySizeException("Ошибка! Размер массива указан неверно");
            for (String j : i
            ) {
                if (j.length() > ARRAY_J || j.length() < 0) throw
                        new MyArraySizeException("Ошибка! Размер массива указан неверно");
                iSumm += Integer.parseInt(j);
            }
        }
        System.out.printf("\nСумма " + iSumm);
    }
}

