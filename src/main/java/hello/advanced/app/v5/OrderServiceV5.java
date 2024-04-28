package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate trace;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.trace = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        trace.execute("OrderService.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
