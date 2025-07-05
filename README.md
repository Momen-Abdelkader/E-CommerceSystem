# E-CommerceSystem
My solution to Fawry Rise Journey Internship Challenge.

# Description
An implementation for an E-Commerce System that includes different types of products, adding items to cart, checkout, and shipping processing. There are normal products, products with expiration date, and products with weight (shippable). A customer adds items to the cart from the available stock then prooceeds to checkout which is when a shipping notice and receipt are generated for this checkout. All the required validation is implemented for invalid states that the system can be in, run the demo for further demonstration. The design decisions for this system are mainly guided by following SOLID principles.

# Main Components

## Interfaces

- `IProduct.java` - Core product interface defining essential operations for name, price, quantity, and inventory management.

- `IShippable.java` - Interface for products that can be shipped, requiring name and weight information for shipping calculations.

- `IExpirable.java` - Interface for products with expiration dates, providing expiration status checking functionality

## System Classes
- `Customer.java` - Customer entity that manages customer information and account balance operations.

- `Cart.java` - Shopping cart implementation that manages cart items, calculates totals, and handles add/remove operations.

- `CartItem.java` - Represents individual items in the shopping cart with requested quantities and price calculations.

- `ShippingService.java` - Handles shipping operations including weight calculations, shipping fees, and package tracking for physical products.

- `CheckoutService.java` - Orchestrates the complete checkout process including validation, inventory updates, payment processing, and receipt generation.

## Product Classes
- `AbstractProduct.java` - Abstract base class that provides common functionality for all product types including name, price, and quantity management.

- `Product.java` - Basic product implementation that don't require shipping or expiration tracking.

- `ShippableProduct.java` - Product that can be shipped, extending basic product functionality with weight management.

- `ExpirableProduct.java` - Product with expiration date functionality that automatically validates freshness during checkout.

- `ExpirableShippableProduct.java` - Combined product type that supports both shipping and expiration date.

# How to run the demo
The demo includes examples of:

- Successful checkout
- Expired product example
- Insufficient balance example
- Empty cart example
- Out-of-stock example

## Method 1
- Run `ECommerceSystem.java` through and IDE.

## Method 2
- Compile and run the `ECommerceSystem.java` main class through terminal:
```bash
javac *.java
java ECommerceSystem
```
