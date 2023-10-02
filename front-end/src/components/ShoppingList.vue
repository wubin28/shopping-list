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

async function createShoppingItem(shoppingItem: any) {
  console.log('ShoppingItem', shoppingItem)
  await axios.post('http://localhost:8081/api/v1/shopping-items', {
    item: shoppingItem.item,
    purchased: shoppingItem.purchased
  })
  ElMessage({
    message: 'Shopping item created',
    type: 'success'
  })
  await loadShoppingItems()
}

async function updateShoppingItem(shoppingItem: any) {
  console.log('ShoppingItem', shoppingItem)
  await axios.put(`http://localhost:8081/api/v1/shopping-items/${shoppingItem.id}`, {
    id: shoppingItem.id,
    item: shoppingItem.item,
    purchased: shoppingItem.purchased
  })
  ElMessage({
    message: 'Shopping Item updated',
    type: 'success'
  })
  await loadShoppingItems()
}
</script>

<template>
  <el-row>
    <el-col :span="12" :offset="7" style="width: 100%">
      <h1>ShoppingList</h1>
      <shopping-item-form @send-message="createShoppingItem"></shopping-item-form>
      <el-table :data="shoppingItems">
        <el-table-column prop="item" label="Item"></el-table-column>
        <el-table-column fixed="right" label="Operations">
          <template #default="scope">
            <el-space wrap>
              <el-switch
                v-model="scope.row.purchased"
                @change="updateShoppingItem(scope.row)"
              ></el-switch>
            </el-space>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<style scoped></style>
