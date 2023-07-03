# sw6633-auction-api
Problem Statement 

You are a group of Software Consultants and you have been approached by a firm that runs an on-site (at some ground location say California), auction business. 
They are planning to expand their business by running the same business over the internet. 
So they have asked you to develop a software system like “eBay” so that they can attract customers from all over the world. 

You need entities and relationships for this project which are as follows: 

• Users: Users can join the site, and for each user we keep their username, real name, password, shipping address, and optionally credit card info.

• Auction/Item (item for auction): Items are offered for auction; the database keeps track of the auctions, and the item description may be an attribute of the auction. 
For each auction, we need to keep a title, item description (or relationship with item), which user started it, and its start and ending time. 
Registered users (and optionally 'guests') can view all items for auction.

• Categories: this is used to categorize the items for auction. Many items can belong to the same category. 
  Optionally, categories can be organized in a hierarchy of subcategories.

• Bidding: Registered users can bid on an item, until the ending time for the item has passed. 
   Each bid needs to be higher than previous bids for the same item. 

Some of the detailed functionalities of this system required by the client are as follows: 

• Main page or a home page where a user can register or login. This is a web page which opens up whenever any guest goes to the site. 
  This page gives the user options like Register (if new to the site), Login(if registered already), View item/items on sale on the site, put up an item for sale or buy an item from the site. 
  The site allows the client/administrators of the site to login and generate the reports as needed. 
  So the home page links to various pages depending upon the choice made by the user. 

• If the user chooses to register to the site, the site opens up a new page asking detailed information from the user like name, address, credit card info, telephone number, username, password, etc
  and updates the database at the backend. Once the user is done registration and clicks on “Submit”, the site takes him to a new page where he can do the operations allowed on the site like buy/sell etc. 
  Constraint on the system: only registered users are allowed to buy and sell items. 
  The guests can only view the items put up for sale. As soon as the guest chooses to buy/sell the message pops up “ To buy or sell, You need to register . 
  It takes 5 minutes to do it and then you can conveniently buy/Sell. Have Fun.” 

• If the user chooses to login, the site opens up a page requesting a user to key in the username and password. 
  The system then verifies the username and password. If it is correct the system opens up a page where the user can perform the operations allowed at the site.
  If the username or the password are not correct the system displays a message” incorrect username/Password” . 
  The system gives the user 3 chances to do it. After that the system takes the user back to the home page. 

• The items that can be put up for sale by the user are categorized in categories like Automobiles, Antiques, Jewelry, Watches, Home & Garden, Electronics etc. 
  This list is prepared as we interview the client. The home page should list all these categories giving the user an option to select any category (to Sell/Buy items).

• Upon the choice made by the user of the category and the transaction that he wants to do(i.e. Sell/Buy) the site opens up a new page either displaying 
  all the items for sale in that category(if the user has chosen to buy an item in that category) OR the site opens up a new page asking for the description of
  the item he wants to sell(if the user has chosen to sell an item in that category).
  
• If the user chooses to buy an item from the list of items for sale in that category, the site opens up a new page giving the item description like what is it, 
  when was it put up by sale, what is the highest bid etc. Additionally it can display a picture of an item if uploaded by the seller. 
  This page allows the user to “Place a bid “ on the chosen item. Once the user chooses to place a bid on an item the site opens up a new page where the buyer needs to give the bid amount, his name & the shipping address etc. Constraint on the system: The bid should be higher than the previous bids. 

• If the user wants to sell an item in a category. The site opens up a page asking the user to give the brief description about the item like “ A Rolex watch, Brand new condition, 4 years old”.
  Here the user needs to give the starting price of the item that he has put up for sale. 
  Also the user can upload a picture of an item if he wants. The system should be able to add this item to the database at the backend. 

Additional Features: The client wants the system to be able to produce several reports for his business purposes: 

• The system should be able to print a report that lists all the items bought in a category on a particular date. 
Additionally it can give info like the price that the item was sold for, the detailed info of the buyer etc. The system should be able to extract the relevant information from the database at the backend to produce this report. 

• The system should be able to print a report that lists all the items that are currently on sale at the site. 
It can give other info like their highest bid, the sellers info, the number of days it has been on sale etc. 

