<template>
    <div id="item">
        <p> {{ employee.name }} </p>
        <p> {{ employee.email }} </p>
        <p> {{ employee.adress }} </p>
        <p> {{ employee.arrival }} </p>
        <Actions @upd-employee="$emit('upd-employee')"
            @delete-employee="$emit('delete-employee')" />
    </div>    
</template>

<script>
import Actions from './Actions'

export default {
    name: 'Employee',
    components: {
        Actions
    },
    props: {
        employee: Object
    },
    methods: {

    }
}
</script>

<style scoped>
#item {
    display: flex;
    justify-content: space-around;
}
/*
#item :hover {
    background-color: rgb(180, 180, 180);
}
*/
</style>