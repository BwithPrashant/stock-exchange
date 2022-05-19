# stock-exchange

Implement an order matching system for a stock exchange.

# Run Book
Edit the file src/resource/data.txt and add you input data.<br />
Driver class has main method.<br />
Test cases has been written inside /src/com/company/test directory.<br />

# Sample input and output

1. 
INPUT<br />
  #1 09:45 BAC sell 240.12 100<br />
  #2 09:46 BAC sell 237.45 90<br />
  #3 09:47 BAC buy 238.10 110<br />
  #4 09:48 BAC buy 237.80 10<br />
  #5 09:49 BAC buy 237.80 40<br />
  #6 09:50 BAC sell 236.00 50<br />
  
  OUTPUT<br />
  #3 237.45 90 #2<br />
  #3 236.0 20 #6<br />
  #4 236.0 10 #6<br />
  #5 236.0 20 #6<br />

2. 
INPUT<br />
  #1 09:45 BAC sell 240.12 100 123<br />
  #2 09:46 BAC random 237.45 90<br />
  #3 09:47 BAC buy wrond_price 110<br />
  #4 09:48 BAC buy 237.80 wrong_quantity<br />
  
  OUTPUT<br />
  Exception : Invalid data: less number of arguemnts<br />
  Exception : Invalid data: invalid order type<br />
  Exception : Invalid data: invalid price<br />
  Exception : Invalid data: invalid quantity<br />
 
3. 
INPUT<br />
  #1 09:45 BAC sell 240.12 100<br />
  #2 09:46 XYZ sell 237.45 90<br />
  #3 09:47 BAC buy 238.10 110<br />
  #4 09:48 BAC buy 237.80 10<br />
  #5 09:49 XYZ buy 237.80 40<br />
  #6 09:50 BAC sell 236.00 50<br />
  
  OUTPUT<br />
  #5 237.45 40 #2<br />
  #3 236.0 50 #6<br />
