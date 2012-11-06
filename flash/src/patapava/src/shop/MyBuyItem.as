package shop {

public class MyBuyItem {
    public var Num:int;
    public var Name_Category:String;
    public var Price:int;

    public function MyBuyItem(item:MyItem) {
        this.Num = item.Num;
        this.Name_Category = new String(item.Name);
        this.Name_Category = this.Name_Category.concat(' (');
        this.Name_Category = this.Name_Category.concat(item.Category);
        this.Name_Category = this.Name_Category.concat(')');
        this.Price = item.Price;
    }

    public function setMyItem(item:Object):MyBuyItem {
        //this.Num =(MyItem(item)).Num;
        //this.Name=(MyItem(item)).Name;
        //	this.Category=(MyItem(item)).Category;
        //this.Year=(MyItem(item)).Year;
        //this.Price=(MyItem(item)).Price;
        return this;
    }

}
}