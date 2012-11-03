/**
 * User: Anton
 * Date: 10.10.12
 * Time: 15:10
 */
package lab2.sender {
import mx.collections.ArrayCollection;


public class DataModel {

    [Bindable]
    public var xmlData:XML;

    [Bindable]
    public var comparisonOperations:ArrayCollection = new ArrayCollection(["<", "<=", "=", ">=", ">"]);

    [Bindable]
    public var types:ArrayCollection = new ArrayCollection();

    [Bindable]
    public var selectedOperation;

    [Bindable]
    public var selectedSquare:String;

    [Bindable]
    public var selectedType;

    [Bindable]
    public var externalData;

    [Bindable]
    public var messageToSend:String;

    public function DataModel() {

    }


}
}
