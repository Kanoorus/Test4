import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest {
    private static Present present = new Present();

    @Test
    public void aTestAssertSummMass() {
        // present.addCandyToMy(new Kozinak(1,1,"1"));
        Assert.assertTrue("Масса подарка должна быть 0", present.getMass() == 0);
    }

    @Test
    public void bTestAssertSummPrice() {
        //present.addCandyToMy(new Kozinak(1,1,"1"));
        Assert.assertTrue("Цена подарка должна быть 0", present.getPrice() == 0);
    }

    @Test
    public void cTestAssertSummPrice() {
        present.addCandyToMy(new Kozinak(0, 1, "1"));
        Assert.assertFalse("Цена подарка больше 0", present.getPrice() > 0);
    }

    @Test
    public void dTestIsEmptyFalse() {
        Assert.assertFalse("Подарок пустой", present.isEmpty());

    }

    @Test
    public void eTestDel() {
        present.dellCandyInMy(1);
        Assert.assertTrue("Подарок не пустой", present.isEmpty());
    }


//
//    @Test
//    public void BtestAddCandy() {
//        Assert.assertTrue("Лист не пустой", Main.getGift().isEmpty());
//        Main.addCFG(Main.getGift(), new Marmalade(1, 2, "Mar", 1));
//        Main.addCFG(Main.getGift(), new Sherbet(2, 2, "Sher", 2));
//        Main.addCFG(Main.getGift(), new Kozinak(3, 3, "Koz", 3));
//        Assert.assertFalse("Лист пустой", Main.getGift().isEmpty());
//
//
//    }
//
//    @Test
//    public void CtestAddedSweetness() {
//        Assert.assertTrue("Мармелад не добавлен в подарок", Main.getGift().get(0) instanceof Marmalade);
//    }
//
//    @Test
//    public void DtestDellCandy() {
//        int sazeA = Main.getGift().size();
//        Main.delCFG(Main.getGift(), 2);
//        int sazeB = Main.getGift().size();
//        if (sazeA == sazeB) System.out.println("Объект не удалился");
//    }
//
//    @Test
//    public void Etest1() {
//        Assert.assertFalse("Объект Sherbet не удалился", Main.getGift().get(1) instanceof Sherbet);
//    }

}
