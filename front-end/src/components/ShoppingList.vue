<script setup lang="ts">
import ShoppingItemForm from '@/components/ShoppingItemForm.vue'
import { ElMessage } from 'element-plus'
import { onMounted, ref } from 'vue'
import axios from 'axios'

onMounted(async () => {
  await loadShoppingItems()
})

const shoppingItems = ref([])

async function loadShoppingItems() {
  try {
    const response = await axios.get('http://localhost:8081/api/v1/shopping-items')
    shoppingItems.value = response.data
    console.log('ShoppingItems', shoppingItems.value)
  } catch (error) {
    console.log('An error occurred:', error)
  }
}

const createShoppingItem = (shoppingItem: any) => {
  console.log('ShoppingItem', shoppingItem)
  ElMessage({
    message: 'Shopping item created',
    type: 'success'
  })
}
</script>

<template>
  <el-row>
    <el-col :span="12" :offset="7" style="width: 100%">
      <h1>ShoppingList</h1>
      <shopping-item-form @send-message="createShoppingItem"></shopping-item-form>
    </el-col>
  </el-row>
</template>

<style scoped></style>
