CREATE OR REPLACE PROCEDURE resetar_senha IS
    
    l_val NUMBER;
    p_seq_name VARCHAR2(100) := 'seq_senha';

BEGIN

    EXECUTE IMMEDIATE
    'SELECT ' || p_seq_name || '.NEXTVAL FROM dual' INTO l_val;
    
    EXECUTE IMMEDIATE
    'ALTER SEQUENCE ' || p_seq_name || ' INCREMENT BY -' || l_val || ' MINVALUE 0';
    
    EXECUTE IMMEDIATE
    'SELECT ' || p_seq_name || '.NEXTVAL FROM dual' INTO l_val;
    
    EXECUTE IMMEDIATE
    'ALTER SEQUENCE ' || p_seq_name || ' INCREMENT BY 1 MINVALUE 0';
    
END;
