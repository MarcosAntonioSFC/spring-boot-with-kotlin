package br.com.learn.services

import br.com.learn.mapper.DozerMapper
import java.lang.reflect.ParameterizedType

abstract class AbstractService<Entity : Any, VO : Any> {

    fun toEntity(objectVO: VO): Entity {
        return DozerMapper.parseObject(objectVO, getEntityType());
    }

    fun toVO(objectVO: Entity): VO {
        return DozerMapper.parseObject(objectVO, getVOType());
    }

    fun toEntities(objectVO: List<VO>): List<Entity> {
        return objectVO.stream()
                .map { toEntity(it) }
                .toList();
    }

    fun toVOs(objectVO: List<Entity>): List<VO> {
        return objectVO.stream()
                .map { toVO(it) }
                .toList();
    }

    fun getEntityType(): Class<Entity> {
        return ((this::class.java.getGenericSuperclass() as (ParameterizedType) ).actualTypeArguments[0] as Class<Entity>)
    }

    fun getVOType(): Class<VO> {
        return ((this::class.java.getGenericSuperclass() as (ParameterizedType) ).actualTypeArguments[1] as Class<VO>)
    }

}
