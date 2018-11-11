package com.example.item.model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;

//@StaticMetamodel(Item.class)
public class Item_X {
	public static volatile SingularAttribute<Item, Categroy> category;
	public static volatile SetAttribute<Item, HashTag> hashTag;
}
