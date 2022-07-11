<template>
  <div class="modal fade cl" id="deviceModal" tabIndex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <form
          @submit.prevent="createDevice"
          :class="submitted ? 'was-validated' : ''"
        >
          <div class="modal-header">
            <h5 class="modal-title">Device Details</h5>
            <button
              class="btn-close"
              type="button"
              data-bs-dismiss="modal"
            ></button>
          </div>

          <div class="modal-body">
            <div class="alert alert-danger" v-if="errorMessage">
              <strong>Error</strong> {{ errorMessage }}
            </div>
            <div class="form-group">
              <label for="name">Name</label>
              <input
                v-model="device.name"
                type="text"
                id="name"
                name="name"
                class="form-control"
                required
              />
              <div class="invalid-feedback">Device name is required</div>
            </div>

            <div class="form-group">
              <label for="description">Description</label>
              <input
                v-model="device.description"
                type="text"
                id="description"
                name="description"
                class="form-control"
                required
              />
              <div class="invalid-feedback">Device description is required</div>
            </div>

            <div class="form-group">
              <label for="price">Price</label>
              <input
                v-model="device.price"
                type="number"
                min="0"
                id="price"
                name="price"
                class="form-control"
                required
              />
              <div class="invalid-feedback">Device price is required</div>
            </div>
            <div class="form-group">
              <label for="type">Device Type</label>
              <select
                v-model="device.deviceType"
                name=""
                id="type"
                class="form-select"
              >
                <option value="" selected>Select Device Type</option>
                <option
                  v-for="(type, index) in deviceTypes"
                  :value="type"
                  :key="index"
                >
                  {{ type }}
                </option>
              </select>
              <div class="invalid-feedback">Type is required</div>
            </div>
          </div>

          <div class="modal-footer">
            <button
              class="btn btn-secondary"
              type="button"
              data-bs-dismiss="modal"
            >
              Close
            </button>
            <button
              class="btn btn-primary"
              type="submit"
              @click="submitted = true"
            >
              Save Changes
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Device from "../models/device";
import DeviceType from "../models/device-type";
import DeviceService from "@/services/device.service";
// import $ from "jquery";

export default {
  name: "device-modal",
  props: {
    selectedDevice: { type: Object },
  },
  data() {
    return {
      device: new Device(),
      errorMessage: "",
      submitted: false,
      deviceTypes: [
        DeviceType.LAPTOP,
        DeviceType.PHONE,
        DeviceType.TABLET,
        DeviceType.DESKTOP,
      ],
    };
  },
  methods: {
    createDevice() {
      if (
        !this.device.name ||
        !this.device.deviceType ||
        !this.device.description ||
        !this.device.price
      ) {
        return;
      }
      DeviceService.saveDevice(this.device)
        .then((response) => {
          // console.log(response.data);
          this.$emit("saved", response.data);
          $("#deviceModal").modal("hide");
        })
        .catch((error) => {
          this.errorMessage = "Unexpected error occurred";
          console.log(error);
        });
    },
    showDeviceModal() {
      this.device = Object.assign({}, this.selectedDevice);
      $("#deviceModal").modal("show");
    },
  },
};
</script>

<style scoped>
</style>
