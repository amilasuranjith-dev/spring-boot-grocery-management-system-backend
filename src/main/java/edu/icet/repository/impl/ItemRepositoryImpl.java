package edu.icet.repository.impl;

import edu.icet.model.dto.ItemDto;
import edu.icet.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addItem(ItemDto itemDto) {
        String sql="INSERT INTO item VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                itemDto.getId(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQty()
                )>0;
    }

    @Override
    public boolean updateItem(ItemDto itemDto) {
        String sql = "UPDATE item SET Description=?,  PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?";
        return jdbcTemplate.update(sql,
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQty(),
                itemDto.getId()
                )>0;
    }

    @Override
    public boolean deleteItem(String id) {
        String sql = "DELETE FROM item WHERE ItemCode=?";
        return jdbcTemplate.update(sql, id)>0;
    }

    @Override
    public ItemDto searchItemById(String id) {
        String sql = "SELECT * FROM item WHERE ItemCode=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(rs.getString(1));
            itemDto.setDescription(rs.getString(2));
            itemDto.setPackSize(rs.getString(3));
            itemDto.setUnitPrice(rs.getDouble(4));
            itemDto.setQty(rs.getInt(5));
            return itemDto;
        }, id);
    }

    @Override
    public List<ItemDto> getAll() {
        String sql = "SELECT * FROM item";
        List<ItemDto> itemDtoList = jdbcTemplate.query(sql, (rs, rowNum)-> {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(rs.getString(1));
            itemDto.setDescription(rs.getString(2));
            itemDto.setPackSize(rs.getString(3));
            itemDto.setUnitPrice(rs.getDouble(4));
            itemDto.setQty(rs.getInt(5));
            return itemDto;
        });
        return itemDtoList;

    }
}
