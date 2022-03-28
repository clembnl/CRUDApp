<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Name</label>
      <input type="text" v-model="name" name="name" placeholder="Name" />
    </div>
    <div class="form-control">
      <label>Email</label>
      <input type="email" v-model="email" name="email" placeholder="Email" />
    </div>
    <div class="form-control">
      <label>Adress</label>
      <input type="text" v-model="adress" name="adress" placeholder="Adress" />
    </div>        
    <div class="form-control">
      <label>Arrival</label>
      <input
        type="date" v-model="arrival" name="arrival" placeholder="Arrival" />
    </div>

    <input type="submit" value="Add Employee" class="btn" />
  </form>    
</template>

<script>
export default {
    name: 'AddForm',
    data() {
        return {
            name: '',
            email: '',
            adress: '',
            arrival: '',
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            const employee = {
                name: this.name,
                email: this.email,
                adress: this.adress,
                arrival: this.arrival
            }

            this.$emit('add-employee', employee)

            this.name = ''
            this.email = ''
            this.adress = ''
            this.arrival = ''
        }
    }
}
</script>