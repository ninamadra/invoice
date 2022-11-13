public class invoiceService {

    private final invoiceRepositoryInterface invoiceRepository;

    public invoiceService(invoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void add(Invoice invoice) {
        invoiceRepository.add(invoice);
    }
}
