package shop {

public class MyItem {
    public var Num:int;
    public var Name:String;
    public var Category:String;
    public var Year:int;
    public var Price:int;

    public function MyItem(num_:int, name_:String, category_:String, year_:int, price_:int) {
        this.Num = num_;
        this.Name = name_;
        this.Category = category_;
        this.Year = year_;
        this.Price = price_;
    }

    public function setMyItem(item:Object):MyItem {
        this.Num = (MyItem(item)).Num;
        this.Name = (MyItem(item)).Name;
        this.Category = (MyItem(item)).Category;
        this.Year = (MyItem(item)).Year;
        this.Price = (MyItem(item)).Price;
        return this;
    }

}
}