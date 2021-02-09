--Insert into "Menu" ("name") 
	--Values ('Breakfast Menu'),('Lunch Menu'),('Dinner Menu')
	
--Insert into "Dishes" ("name") 
	--Values ('Bacon Egg and Cheese Melt'),('Hamburger'),('Waffle Fries')
	
--Insert into "Suppliers" ("name") 
	--Values ('Todd'),('Evan'),('Patty')

--Insert into "TableTops" ("seatCount") 
	--Values ('3'),('3'),('15')
	
 --INSERT into "Ingredients" ("name", "stock","units" "isOrganic")
 	--VALUES ('Eggs', '36','One Egg', 'true'), ('Bacon Strips', '24.5','lbs', 'false'),('Potatoes', '16', 'lbs', 'true')
	
--INSERT into "Recipes" ("dishId", "name", "instructions")
	--VALUES ('3', 'Regular', '1. Cut Potatoes into waffle shape. 2. Fry them'), 
			--('3', 'Baked','1. Cut Potatoes into waffle shape. 2. Bake them'),
			--('2', 'Regular', '1.Cook meat to desired temperature. 2. Prepare bread with mayo, lettuce, cheese, onions. 3. Put everything together')
--INSERT into "Orders" ("tableTopId")	
	--VALUES ('1'),('2'),('3')
--INSERT into "RecipeIngredients" ("recipeId","ingredientId","quantity", "unit")
	--VALUES ('1','3','1', 'lbs'),('2','3','1','lbs'),('3','2','.25','lbs')
	
--INSERT into "MenuDishes" ("menuId", "dishId", "price")
	--VALUES ('1','1','6.00'),('2','2','8.00'),('2','3','3.00')
	
--insert into "SupplierIngredients" ("supplierId", "ingredientId", "qtyAvailable", "units" , "unitCost")
	--values ('1','3','20','lbs','1.00'),('1','2','15','lbs', '.95'),('2','3','25','lbs','.85');
	
--insert into "OrderDishes" ("orderId",  "dishId", "menuId", "quantity")
	--values ('1','2','2','2'),('1','3','2','3'),('2','2','2','3')
	