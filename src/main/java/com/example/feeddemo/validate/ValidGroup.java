package com.example.feeddemo.validate;

import javax.validation.groups.Default;

/**
 * Created by xiedong
 * Date: 2022/7/9
 */
public interface ValidGroup extends Default {

    interface Crud extends ValidGroup {
        interface Create extends Crud {

        }

        interface Update extends Crud {

        }

        interface Query extends Crud {

        }

        interface Delete extends Crud {

        }
    }
}

