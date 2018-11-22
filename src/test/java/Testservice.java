import com.risechina.erp.impl.ERP_ServiceImpl;

public class Testservice {

    public static void main(String[] args) {
        ERP_ServiceImpl erp_service = new ERP_ServiceImpl();
        String aesSeed = erp_service.getAesSeed("111111111111111");

        System.out.println(aesSeed);

    }
}
