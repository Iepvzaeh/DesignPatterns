package chainofresponsibility;

public class President extends Handler {
    
    private final double raiseAcceptThreshold = 10.0;
    
    @Override
    public void handleRaiseRequest(double percent) {
        if (percent <= raiseAcceptThreshold) {
            System.out.println("The " + this.getClass().getSimpleName().toLowerCase() + " accepts the " + percent + "% raise request.");
        } else {
            System.out.println("The " + this.getClass().getSimpleName().toLowerCase() + " cannot accept the " + percent + "% raise request. ");
            super.handleRaiseRequest(percent);
        }
    }
}
