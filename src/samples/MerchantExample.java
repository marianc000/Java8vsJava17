package samples;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class MerchantExample {

    List<Merchant> findTopMerchants(
            List<Sale> sales, List<Merchant> merchants, int year, Month month) {

        // Local record class
        record MerchantSales(Merchant merchant, double sales) {
        }

        return merchants.stream()
                .map(merchant -> new MerchantSales(
                        merchant, this.computeSales(sales, merchant, year, month)))
                .sorted((m1, m2) -> Double.compare(m2.sales(), m1.sales()))
                .map(MerchantSales::merchant)
                .collect(Collectors.toList());
    }

    double computeSales(List<Sale> sales, Merchant mt, int yr, Month mo) {
        return sales.stream()
                .filter(s -> s.merchant().name().equals(mt.name()) &&
                        s.date().getYear() == yr &&
                        s.date().getMonth() == mo)
                .mapToDouble(s -> s.value())
                .sum();
    }

    public static void main(String[] args) {

        Merchant sneha = new Merchant("Sneha");
        Merchant raj = new Merchant("Raj");
        Merchant florence = new Merchant("Florence");
        Merchant leo = new Merchant("Leo");

        List<Merchant> merchantList = List.of(sneha, raj, florence, leo);

        List<Sale> salesList = List.of(
                new Sale(sneha, LocalDate.of(2020, Month.NOVEMBER, 13), 11034.20),
                new Sale(raj, LocalDate.of(2020, Month.NOVEMBER, 20), 8234.23),
                new Sale(florence, LocalDate.of(2020, Month.NOVEMBER, 19), 10003.67),
                // ...
                new Sale(leo, LocalDate.of(2020, Month.NOVEMBER, 4), 9645.34));

        MerchantExample app = new MerchantExample();

        List<Merchant> topMerchants =
                app.findTopMerchants(salesList, merchantList, 2020, Month.NOVEMBER);
        System.out.println("Top merchants: ");
        topMerchants.stream().forEach(m -> System.out.println(m.name()));
    }
}
