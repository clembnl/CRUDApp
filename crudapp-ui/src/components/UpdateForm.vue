<template>
    <form @submit="onSubmit" class="upd-form">
        <div class="form-control">
            <label>Name</label>
            <input type="text" v-model="name" name="name" placeholder={{employee.name}} />
        </div>
        <div class="form-control">
            <label>Email</label>
            <input type="email" v-model="email" name="email" placeholder={{employee.email}} />
        </div>
        <div class="form-control">
            <label>Adress</label>
            <input type="text" v-model="adress" name="adress" placeholder={{employee.adress}} />
        </div>        
        <div class="form-control">
            <label>Arrival</label>
            <input type="date" v-model="arrival" name="arrival" placeholder={{employee.arrival}} />
        </div>

        <input type="submit" value="Update Employee" class="btn" />
    </form>    

</template>

<script>
export default {
    name: 'UpdateForm',
    data() {
        return {
            name: '',
            email: '',
            adress: '',
            arrival: '',
        }
    },
    props: {
        employee: Object
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            employee.name = this.name
            employee.email = this.email
            employee.adress = this.adress
            employee.arrival = this.arrival

            this.$emit('upd-employee', employee)

            this.name = ''
            this.email = ''
            this.adress = ''
            this.arrival = ''
        }
    }
}
</script>