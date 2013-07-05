randomorg
=========

Random generator via atmospheric noise [Random.org](http://random.org)
=========

**Current version:** 0.1

### Getting started

**Integer Generator**

``` java
// generate two 6-side dice rolls
IntegerGenerator ig = new IntegerGenerator();
ig.generate(1,6,2)
```

**Sequence Generator**

``` java
// shuffle 52-card deck
SequenceGenerator sg = new SequenceGenerator();
sg.generate(1, 52);
```

**String Generator**

``` java
// new password alphanumeric 12 chars
StringGenerator strg = new StringGenerator();
strg.generate(12, 1, true, true, true, true);
```

**Quota Checker**

``` java
// check your remaining quota
QuotaChecker qc = new QuotaChecker();
qc.quota();
```

### Implementation

All work with HTTP GET API happens in **HTTPUtils** util class. As we do not know
return type for concrete GET-request yet we return `ArrayList<String>` which
further can be processed by responsible methods.

All succesful request equal to server response code 200.
In case server returns 503 response code, IOException is thrown and should be
handled on client side.

### Build

`gradle build`