
delimiter $
create procedure updateSalaryByWorkingDays(IN p_emp_id INT)

    declare join_date DATE;
    declare work_days INT;
    declare current_salary DECIMAL(10,2);
    declare new_salary DECIMAL(10,2);

   
    select joining_date, salary into join_date, current_salary
    from employee where empno = p_emp_id;

 
    SET work_days = getWorkingDays(join_date);

   
	if work_days > 300 then
		set new_salary = current_salary * 1.20;  -- 20% hike
	elseif work_days between 200 and 300 then
		set new_salary = current_salary * 1.10;  -- 10% hike
	else
		set new_salary = current_salary * 1.05;  -- 5% hike
	end if;

	update employee
	set salary = new_salary
	where emp_id = p_emp_id;

	select concat('salary updated for employee ', p_emp_id,
				  ' to ', new_salary,
				  ' based on ', work_days, ' working days.') as message;

end $

delimiter ;
