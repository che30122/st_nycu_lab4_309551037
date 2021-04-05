package lab04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {

    private static Stream<Arguments> getParameters(){

        return Stream.of(arguments("rock","rock",0),
                arguments("rock","paper",-1),
                arguments("rock","scissors",1),
                arguments("paper","rock",1),
                arguments("paper","paper",0),
                arguments("paper","scissors",-1),
                arguments("scissors","rock",-1),
                arguments("scissors","paper",1),
                arguments("scissors","scissors",0));
    }
    @Test
    public void test_invalid_input() {
        Exception e=assertThrows(IllegalArgumentException.class,()->{
           Game.validate_input("adfafd");
        });
    }

    @Test
    public void test_valid_input(){
        assertDoesNotThrow(()->{
            for(String c:Game.valid_input.keySet()){
                Game.validate_input(c);
            }
        });
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void game(String p1,String p2,int answer) {
        assertEquals(Game.game(p1,p2),answer);
    }
}