package service;

import domain.IPWClass;

public sealed interface IGenericServices<T extends IPWClass> permits IAllServices,IDungeonServices,IQuestServices{
}
