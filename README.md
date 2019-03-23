<b> Name: </b> <br>
  <p class="float-left"> Rates </p> <br>
<b> Description: </b> <br>
  Project consists of two modules: 1-crypto-rates and 2-crypto-rates-client-app.
  First one generates rates randomly for Bitcoin and Ethereum and saves them into repo.
  Second one calls a rest-controller and draws the chart for the rates. <br>
<b> Implementation: </b> <br>
  java11, gradle 5.2, springboot 2.1.3, reactor, spring data, embedded mongo. <br>
<b> Run instructions: </b> <br>
  1). Run CurrencyRatesFluxApplication.java from the 1-crypto-rates module,
  2). Run CurrencyRatesClientApplication.java from 2-crypto-rates-client-app module,
  3). Open your browser and go to localhost:8081/rates,
  4). You will see a chart for randomly generated bitcoin and ethereum rates.
  <br>
