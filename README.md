Brendan O'Dowd

December 26th, 2020

Design 

Product Class -> The purpose of this class is to define what a Product is. The product contains fields to hold the price of the product,the quantity, the product type, and whether it is an imported product.
                 

Cart Class -> The Cart class holds the majority of the logic of this project. The Cart constructor simply calls the methods within its own class, first enterItems(). This method takes user input and calls the parseInput() method. This method handles the logic to parse the user input and break it down into quantity, product type, price, and import status. The appropriate taxes are then added to the price and rounded up accordingly. Using a hashmap, I can keep track of duplicate products, a duplicate in this implementation has been defined as a product with the same name and price. If we come across a duplicate product, we will increment the quantity, rather than putting a new product in the map. The printRecipt() method is then called, which prints out each product in the hashmap, according to the Product class toString method.            

Main Class -> Creates a new instance of the Cart class which handles all logic. This is the entry point for the project.

Assumptions:
- This implementation assumes that the user input will also be formatted as such: "1 Box of Chocolates at 1.99"
- In order to stop entering items, the user should enter "Done Shopping"
- The tax free items listed in the project description are Books, Food, and Medicines. I hard coded to show as tax exempt if the product contains the word Book, Chocolate, or       headache as examples. Others will not be counted as tax free, for example "1 Pizza at 18.99" will be shown with sales tax included.

Example Input:
1 Book at 12.49
1 Book at 12.49
1 Music CD at 14.99
1 Chocolate bar at 0.85

Output:
Book: 24.98 (2 @ 12.49)
Music CD: 16.49
Chocolate bar: 0.85
Sales Taxes: 1.50
Total: 42.32
