<template>
    <form @submit="onSubmit" class="upd-form">
        <div class="form-control">
            <label>Name</label>
            <input type="text" v-model="name" name="name" :placeholder="[employee.name]" />
        </div>
        <div class="form-control">
            <label>Email</label>
            <input type="email" v-model="email" name="email" :placeholder="[employee.email]" />
        </div>
        <div class="form-control">
            <label>Adress</label>
            <input type="text" v-model="adress" name="adress" :placeholder="[employee.adress]" />
        </div>        
        <div class="form-control">
            <label>Arrival</label>
            <input type="date" v-model="arrival" name="arrival" :placeholder="[employee.arrival]" />
        </div>

        <input type="submit" value="Update Employee" class="btn" />
    </form>    

</template>

<script>
export default {
    name: 'UpdateForm',
    props: {
        employee: Object
    },    
    data() {
        return {
            id: this.employee.id,
            name: this.employee.name,
            email: this.employee.email,
            adress: this.employee.adress,
            arrival: this.employee.arrival,
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            this.employee.name = this.name
            this.employee.email = this.email
            this.employee.adress = this.adress
            this.employee.arrival = this.arrival

            this.$emit('upd-employee', this.employee)
        }
    },
    emits: ['upd-employee']
}
</script>