public class SomeClass {
    @BeforeSuite
    public void init() {
        System.out.println("init");
    }

    @Test(priority = 3)
    public void test_one() {
        System.out.println("test_one");
    }

    @Test(priority = 7)
    public void test_two() {
        System.out.println("test_two");
    }

    @Test(priority = 1)
    public void test_tree() {
        System.out.println("test_tree");
    }

    @Test(priority = 4)
    public void test_four() {
        System.out.println("test_four");
    }

    public void any_method() {
        System.out.println("any_five");
    }

    @AfterSuite
    public void end() {
        System.out.println("end");
    }
}
