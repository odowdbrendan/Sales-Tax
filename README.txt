Brendan O'Dowd - DealerOn Submission 

Design 
Product Class -> The purpose of this class is to define what a Product is. The product contains fields to hold the price of the product,the quantity, the product type, and whether it is an imported product.
                 

Cart Class -> The Cart class holds the majority of the logic of this project. The Cart constructor simply calls the methods within its own class, first enterItems(). This method takes user input and adds them to a hashmap. The method also handles the logic to parse the user input and break it down into quantity, product type, price, and import status. The appropriate taxes are then added to the price and rounded up accordingly. Using a hashmap, I can keep track of duplicate products, a duplicate in this implementation has  been defined as a product with the same name and price. If we come across a duplicate product, we will increment the quantity, rather than putting a new product in the map. The printRecipt() method is then called, which prints out each product in the hashmap, according to the Product class toString method.            

Main Class -> Creates a new instance of the Cart class which handles all logic. This is the entry point for the project.

Assumptions:
- This implementation assumes that the user input will also be formatted as such: "1 Box of Chocolates at 1.99"
- In order to stop entering items, the user should enter "Done Shopping"

            
            
             

            
             
              
