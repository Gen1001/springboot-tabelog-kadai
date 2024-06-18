const stripe =  Stripe('pk_test_51PQhzT2NbiYi2A8o9xLMePNWtE6KTdbjgulApXG45B8abwJxLDL2BitkAR5Ccv15ARqtnMF0GmC1sIfH2dk6ptOG00CigDmSt3');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
  stripe.redirectToCheckout({
    sessionId: sessionId
  })
});