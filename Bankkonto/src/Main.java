void main() {
    Konto konto = new Konto(1000);

    KundenThread kundenThread1 = new KundenThread(konto);
    KundenThread kundenThread2 = new KundenThread(konto);
    KundenThread kundenThread3 = new KundenThread(konto);

    kundenThread1.start();
    kundenThread2.start();
    kundenThread3.start();

    try {
        kundenThread1.join();
        kundenThread2.join();
        kundenThread3.join();
    } catch (InterruptedException e) {

    }
}
