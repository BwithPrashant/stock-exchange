# stock-exchange

Implement an order matching system for a stock exchange.

# run book
Edit the file src/resource/data.txt and add you input data.
Driver class has main method.
Test cases has been written inside /src/com/company/test directory.

# Sample input and output

1. INPUT
  #1 09:45 BAC sell 240.12 100
  #2 09:46 BAC sell 237.45 90
  #3 09:47 BAC buy 238.10 110
  #4 09:48 BAC buy 237.80 10
  #5 09:49 BAC buy 237.80 40
  #6 09:50 BAC sell 236.00 50
  
  OUTPUT
  #3 237.45 90 #2
  #3 236.0 20 #6
  #4 236.0 10 #6
  #5 236.0 20 #6

2. INPUT
  #1 09:45 BAC sell 240.12 100 123
  #2 09:46 BAC random 237.45 90
  #3 09:47 BAC buy wrond_price 110
  #4 09:48 BAC buy 237.80 wrong_quantity
  
  OUTPUT
  Exception : Invalid data: less number of arguemnts
  Exception : Invalid data: invalid order type
  Exception : Invalid data: invalid price
  Exception : Invalid data: invalid quantity
 
3. INPUT
  #1 09:45 BAC sell 240.12 100
  #2 09:46 XYZ sell 237.45 90
  #3 09:47 BAC buy 238.10 110
  #4 09:48 BAC buy 237.80 10
  #5 09:49 XYZ buy 237.80 40
  #6 09:50 BAC sell 236.00 50
  
  OUTPUT
  #5 237.45 40 #2
  #3 236.0 50 #6
