<b> Name: </b> <br>
  Rates <br><br>
<b> Description: </b> <br>
  Project consists of two modules: 1-crypto-rates and 2-crypto-rates-client-app.
  First one generates rates randomly for Bitcoin and Ethereum and saves them into repo.
  Second one calls a rest-controller and draws the chart for the rates. <br><br>
<b> Implementation: </b> <br>
  java11, gradle 5.2, springboot 2.1.3, reactor, spring data, embedded mongo. <br><br>
<b> Run instructions: </b> <br>
1). Run CurrencyRatesFluxApplication.java from the 1-crypto-rates module,
2). Run CurrencyRatesClientApplication.java from the 2-crypto-rates-client-app module,<br>
3). Open your browser and go to localhost:8081/rates,<br>
4). You will see a chart for randomly generated bitcoin and ethereum rates.
