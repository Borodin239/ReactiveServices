package com.borodin239.exceptions

class CurrencyNotFoundException(curr: String) : Exception("Currency with name $curr doesn't exists")