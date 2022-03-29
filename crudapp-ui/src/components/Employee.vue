<template>
    <div id="employee">
        <p> {{ employee.name }} </p>
        <p> {{ employee.email }} </p>
        <p> {{ employee.adress }} </p>
        <p> {{ employee.arrival }} </p>
        <Actions @upd-employee="$emit('upd-employee', this.employee)"
            @delete-employee="$emit('delete-employe', this.employee.id)" />
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
#employee {
    display: flex;
    justify-content: space-around;
}

#employee :hover {
    background-color: rgb(180, 180, 180);
}
</style>