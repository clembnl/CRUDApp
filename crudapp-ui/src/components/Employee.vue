<template>
    <div id="item">
        <p> {{ employee.name }} </p>
        <p> {{ employee.email }} </p>
        <p> {{ employee.adress }} </p>
        <p> {{ employee.arrival }} </p>
        <Actions @upd-employee="$emit('upd-employee')"
            @delete-employee="$emit('delete-employee')" 
            id="action" />
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

#item p {
    padding: 10px;
    margin: 0;
    text-align: center;
}

@media only screen and (min-width: 660px) {
    #item p {
        width: 20%;
    }
}

@media only screen and (max-width: 660px) {
    #item {
        flex-direction: column;
    }

    #item p {
        margin: auto;
    }

    #action {
        margin: auto;
    }
}
</style>