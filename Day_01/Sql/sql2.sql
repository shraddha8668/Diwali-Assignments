
drop function if exists getWorkingDays;
delimiter $
create function getWorkingDays(join_date DATE)
returns int deterministic
begin
    declare total_days INT;
    declare weekends INT;
    declare working_days INT;

    
    set total_days = DATEDIFF(CURDATE(), join_date);

    
    set weekends = floor(total_days / 7) * 2;

   
    set working_days = total_days - weekends;

    return working_days;
end $$

delimiter ;
